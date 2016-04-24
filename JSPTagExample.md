All the code examples are checked into subversion. The best way to present these examples may be to just let you walk through the source code.

  * [Controller](http://jmesa.googlecode.com/svn/tags/jmesaWeb-3.0/src/org/jmesaweb/controller/TagPresidentController.java)
  * [JSP](http://jmesa.googlecode.com/svn/tags/jmesaWeb-3.0/web/jsp/tag.jsp)
  * [FilterMatcherMap](http://jmesa.googlecode.com/svn/tags/jmesaWeb-3.0/src/org/jmesaweb/controller/TagFilterMatcherMap.java)

Be sure to pay attention to the [Javascript](Javascript.md) page link so that you understand how Javascript is used to interact with the table through the onInvokeAction and onInvokeExportAction.

**Note:** If you have a date or numeric column then chances are that you will want to format it. See the [Editors](Editors.md) page for more details on how to do that. Be sure to add a custom [filter strategy](FilterMatcher.md) if your column is filterable.

