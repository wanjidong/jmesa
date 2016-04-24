The next release of JMesa is mostly going to be about rolling out the JMesa JavaScript file as a jQuery plugin. That is also the main motivation for moving up to a 2.4 release...just to reflect that this is a fairly big change. Although I really do not expect any breaking changes.

One big thing you might have noticed is that with each release more and more code is being contributed to JMesa. I really enjoy getting code contributions from developers. I think its interesting when either bugs are discovered or new features are implemented because of working with JMesa tables in a way I had not thought of.

Here is the current list of changes:

  * German Locale (de). Contributed by Stefan Barucha
  * Turkish Locale (tr\_TR). Contributed by Erdem Yilmaz
  * Better data encoding in the worksheet and filter ([issue 155](http://code.google.com/p/jmesa/issues/detail?id=155)). Contributed by Frode Reinertsen.
  * JMesa JavaScript is re-written as a jQuery plugin ([issue 128](http://code.google.com/p/jmesa/issues/detail?id=128)). Contributed by Benjamin Gould.
  * Searching for the valid page is non-recursive. This is more of a technical change and there was a custom implementation that found this edge case [(issue 151)](http://code.google.com/p/jmesa/issues/detail?id=151). Contributed by David Sills.
  * Doing additional check when working with the TableFacade [(issue 127)](http://code.google.com/p/jmesa/issues/detail?id=127).
  * PdfPView null pointer fix [(issue 142)](http://code.google.com/p/jmesa/issues/detail?id=142).
  * Doing a check to make sure that the maxRowIncrements contains the maxRows [(issue 95)](http://code.google.com/p/jmesa/issues/detail?id=95).
  * Expression evaluation from Java code ([issue 145](http://code.google.com/p/jmesa/issues/detail?id=145)). Contributed by Benjamin Gould.

#### Expression Evaluation Example ####
All three of these code snippets do the same thing...putting the first and last name together using JavaScript notation. Even though this example is in JavaScript all the popular scripting languages are supported through the Apache [Bean Scripting Framework](http://jakarta.apache.org/bsf/). In addition there is support for doing EL expressions as well.

```
CellEditor lastNameCellEditor 
                = new ExpressionCellEditorFactoryImpl().createCellEditor(new Expression(Language.JAVASCRIPT, "item", "item.name.lastName + ', ' + item.name.firstName"));
lastName.getCellRenderer().setCellEditor(lastNameCellEditor);
```

or

```
CellEditor lastNameCellEditor = new BsfExpressionCellEditor(new Expression(Language.JAVASCRIPT, "item", "item.name.lastName + ', ' + item.name.firstName"));
lastName.getCellRenderer().setCellEditor(lastNameCellEditor);
```

or

```
CellEditor lastNameCellEditor = new BsfExpressionCellEditor(Language.JAVASCRIPT, "item", "item.name.lastName + ', ' + item.name.firstName");
lastName.getCellRenderer().setCellEditor(lastNameCellEditor);
```