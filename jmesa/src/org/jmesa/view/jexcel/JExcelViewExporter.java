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
package org.jmesa.view.jexcel;

import javax.servlet.http.HttpServletResponse;

import jxl.write.WritableWorkbook;

import org.jmesa.util.ExportUtils;
import org.jmesa.view.AbstractViewExporter;
import org.jmesa.view.View;

/**
 * <p>
 *  Output the JExcel results out to the response.
 * </p>
 * 
 * @since 2.2
 * @author Paul Horn
 */
public class JExcelViewExporter extends AbstractViewExporter {
    private View view;
    private HttpServletResponse response;
    private String fileName;

    public JExcelViewExporter(View view, HttpServletResponse response) {
        this.view = view;
        this.response = response;
        this.fileName = ExportUtils.exportFileName(view, "xls");
    }

    public JExcelViewExporter(View view, String fileName, HttpServletResponse response) {
        this.view = view;
        this.fileName = fileName;
        this.response = response;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void export() 
            throws Exception {
        ((JExcelView) view).setOut(response.getOutputStream());
        WritableWorkbook workbook = (WritableWorkbook) view.render();
        responseHeaders(response);
        workbook.write();
        response.getOutputStream().flush();
        workbook.close();
    }
    
    @Override
    public void responseHeaders(HttpServletResponse response)
            throws Exception {
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        fileName = new String(fileName.getBytes(), "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setDateHeader("Expires", (System.currentTimeMillis() + 1000));
    }
}
