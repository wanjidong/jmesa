++ _Denotes an attribute in which you need to specify the fully qualified path to the class implementation._

#### TableModelTag ####
| **Attribute** | **Type** | **Description** |
|:--------------|:---------|:----------------|
| id            | String   | The unique table id. |
| [items](Items.md) | Collection | The Collection of beans or maps. |
| limit         | [Limit](Limit.md) | The Limit object to use. |
| maxRows       | int      | The max page rows. |
| maxRowsIncrements | String[.md](.md) | The comma separated list of max rows increments. |
| stateAttr     | String   | The parameter to use for the [State](State.md). |
| exportTypes   | String[.md](.md) | The comma separated list of exports. |
| autoFilterAndSort | boolean  | Whether the API should filter and sort the items. |
| filterMatcherMap | [FilterMatcherMap](FilterMatcher.md) ++ | Used to register custom filter matchers. |
| view          | [View](View.md) ++ | The View object to use. |
| messages      | [Messages](Messages.md) ++ | The Messages to use. |
| preferences   | [Preferences](Preferences.md) ++ | The Preferences to use. |
| columnSort    | ColumnSort ++ | The ColumnSort to use. |
| rowFilter     | RowFilter ++ | The RowFilter to use. |
| toolbar       | Toolbar ++ | The Toolbar to use. |
| var           | String   | The value to hold the current bean while iterating over the rows. |

#### HtmlTableTag ####
| **Attribute** | **Type** | **Description** |
|:--------------|:---------|:----------------|
| caption       | String   | The caption for the table. |
| captionKey    | String   | The caption value to find in the messages. |
| theme         | String   | The css style sheet to use. |
| width         | String   | The width of the table. |
| tableRenderer | [TableRenderer](Renderers.md) ++ | The TableRenderer to use. |
| style         | String   | The css style attribute for the table. |
| styleClass    | String   | The css class attribute for the table. |
| border        | String   | The table border attribute. |
| cellpadding   | String   | The table cellpadding attribute. |
| cellspacing   | String   | The table cellspacing attribute. |

#### HtmlRowTag ####
| **Attribute** | **Type** | **Description** |
|:--------------|:---------|:----------------|
| highlighter   | boolean  | Whether to show the row highlighter effect. |
| highlightStyle | String   | The css style attribute for the row highlighter. |
| highlightClass | String   | The css class attribute for the row highlighter. |
| onclick       | [RowEvent](Components.md) ++ | The row onclick event. |
| onmouseout    | [RowEvent](Components.md) ++ | The row onmouseout event. |
| onmouseover   | [RowEvent](Components.md) ++ | The row onmouseover event. |
| rowRenderer   | [RowRenderer](Renderers.md) ++ | The RowRenderer to use. |
| style         | String   | The css style attribute for the row. |
| styleClass    | String   | The css class attribute for the row. |
| evenClass     | String   | The css class attribute for the even rows. |
| oddClass      | String   | The css class attribute for the odd rows. |

#### HtmlColumnTag ####
| **Attribute** | **Type** | **Description** |
|:--------------|:---------|:----------------|
| property      | String   | The bean or map attribute from the [items](Items.md). |
| title         | String   | The column header title. |
| titleKey      | String   | The value to find in the messages. |
| cellEditor    | [CellEditor](Editors.md) ++ | The CellEditor to use. |
| headerEditor  | [HeaderEditor](Editors.md) ++ | The HeaderEditor to use. |
| filterEditor  | [FilterEditor](Editors.md) ++ | The FilterEditor to use. |
| pattern       | String   | The pattern to inject into the [DateCellEditor](Editors.md) or [NumberCellEditor](Editors.md). |
| filterable    | boolean  | Whether the column should be filtered. |
| sortable      | boolean  | Whether the column should be sorted. |
| sortOrder     | String[.md](.md) | The comma separated way a column is sorted. |
| width         | String   | The width of the column. |
| cellRenderer  | [CellRenderer](Renderers.md) ++ | The CellRenderer to use. |
| filterRenderer | [FilterRenderer](Renderers.md) ++ | The FilterRenderer to use. |
| headerRenderer | [HeaderRenderer](Renderers.md) ++ | The HeaderRenderer to use. |
| style         | String   | The css style attribute for the column. |
| styleClass    | String   | The css class attribute for the column. |
| headerStyle   | String   | The css style attribute for the column header. |
| headerClass   | String   | The css class attribute for the column header. |
| filterStyle   | String   | The css style attribute for the column filter. |
| filterClass   | String   | The css class attribute for the column filter. |

#### HtmlColumnsTag ####
| **Attribute** | **Type** | **Description** |
|:--------------|:---------|:----------------|
| htmlColumnsGenerator | [HtmlColumnsGenerator](HtmlColumnsGenerator.md) ++ | The HtmlColumnsGenerator to use. |