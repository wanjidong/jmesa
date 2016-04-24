#### How can I change the header on the table to display other things (like a checkbox)? ####

The header row on the table works with the HeaderEditor interface behind the scenes. The default header editor is the HtmlHeaderEditor.

To create your own header editor you typically extend the AbstractHeaderEditor. This gives you access to CoreContext, WebContext and Column. You could also just implement the HeaderEditor directly if you do not need access to any of these.

For more information read the [Editors](Editors.md) page.

#### How do I change the header row to use a 'th' versus a 'td' element? ####

A few developers requested that there be a way to default the html header column element to a th versus a td definition.

The default is still a 'td' element but you can redefine it in the [Preferences](Preferences.md) if needed.

```
html.column.header.renderer.element=td
```

#### How do I format a date or number in my column? ####

If you have a date or numeric column then chances are that you will want to format it. See the [Editors](Editors.md) page for more details on how to do that. Be sure to add a custom [filter strategy](FilterMatcher.md) if your column is filterable.

#### How do I limit the column to only sort asc or desc? ####

You would need to set the sort order on the html column using the [sortOrder](Components.md) method.

#### What kind of advanced look and feel changes are possible? ####

See the [CSS Tips](CSSTips.md) If you want more advanced styling like the 3D header and drop shadow effect.

#### How can I use the table without pagination to display all the rows at once? ####

Because of how customizable JMesa is you just need to create a custom view to remove the toolbar, and then set the max rows to the total rows. You can find an example [here](TableWithoutPagination.md)

#### How do I group the columns? ####

You can use the GroupColumnsHtmlView view. See the [tutorial](GroupColumnsTutorial.md) for more information.