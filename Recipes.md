I thought it would be a good format for pulling together the JMesa documentation. This will be a work in progress, but the goal is to make this the jumping point to the rest of the wiki. The way this will work is each high level section will be broken down into a question with a brief answer, along with a reference to the rest of the wiki.

  * [Filter Recipes](FilterRecipes.md)
  * [Sort Recipes](SortRecipes.md)
  * [Toolbar Recipes](ToolbarRecipes.md)
  * [Table Recipes](TableRecipes.md)
  * [Export Recipes](ExportRecipes.md)
  * [Controller Recipes](ControllerRecipes.md)
  * [JSP Tag Recipes](JSPTagRecipes.md)
  * [Worksheet Recipes](WorksheetRecipes.md)
  * [Misc Recipes](MiscRecipes.md)
  * [Export Recipes](ExportRecipes.md)
  * [Portlet Recipes](PortalExample.md)

#### Introduction to JMesa ####

JMesa takes a Collection of beans or a Collection of maps and uses them to render a table in HTML, XLS, CSV, or any other format you choose. The beans in the Collection are plain old Java objects (POJO) where each attribute has a corresponding getter and setter method. If using maps the attributes would be name-value pairs. You can think of each bean as being one row in the table display.

The [overview](Overview.md) will also get you started learning about the [Limit](Limit.md), [CoreContext](CoreContext.md) and [View](View.md).