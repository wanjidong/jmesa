/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.view.html.editor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.jmesa.limit.Filter;
import org.jmesa.limit.Limit;
import org.jmesa.util.ItemUtils;
import org.jmesa.view.editor.AbstractFilterEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;

/**
 * Create a droplist for the filter.
 * 
 * @since 2.3
 * @author Jeff Johnston
 */
public class DroplistFilterEditor extends AbstractFilterEditor {

    public Object getValue() {
        HtmlBuilder html = new HtmlBuilder();

        Limit limit = getCoreContext().getLimit();
        HtmlColumn column = (HtmlColumn) getColumn();
        String property = column.getProperty();
        Filter filter = limit.getFilterSet().getFilter(property);

        String filterValue = "";
        if (filter != null) {
            filterValue = filter.getValue();
        }

        
        String name = limit.getId() + property + "FilterOptions";

        StringBuilder javascript = new StringBuilder();
        javascript.append("var ").append(name).append("={};");

        Collection<Object> options = getOptions();
        for (Object option : options) {
            option = StringEscapeUtils.escapeJavaScript(option.toString());
            javascript.append(name).append("['");
            javascript.append(option).append("']='").append(option).append("';");
        }

        html.script().type("text/javascript").close().append(javascript).scriptEnd();
        html.div().styleClass("dynFilter");
        html.onclick("createDynDroplistFilter(this,'" + limit.getId() + "','" + column.getProperty() + "'," + name + ")");
        html.close();
        html.append(filterValue);
        html.divEnd();

        return html.toString();
    }

    private Collection<Object> getOptions() {
        Set<String> options = new HashSet<String>();

        String property = getColumn().getProperty();

        for (Object item : getCoreContext().getAllItems()) {
            Object val = ItemUtils.getItemValue(item, property);
            if (val != null && String.valueOf(val).length() > 0) {
                options.add(String.valueOf(val));
            }
        }

        List<Object> results = Arrays.asList(options.toArray());
        if (results != null && results.size() > 0) {
            Collections.sort(results, null);
        }

        return results;
    }

}
