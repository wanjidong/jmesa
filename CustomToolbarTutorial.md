The following tutorial shows how to create a custom toolbar. The reason you might want to do such a thing is to either replace the default functionality or add your own toolbar items. This example assumes you are wanting to add your own toolbar item to do something custom. The objective will be to print out an alert that display 'Hello World'. Although typically not the most useful function in a production environment, it does show the steps needed to create your own toolbar item!

![http://jmesa.org/wiki/images/custom-toolbar.gif](http://jmesa.org/wiki/images/custom-toolbar.gif)

You can see the full example [here](http://code.google.com/p/jmesa/source/browse/trunk/jmesaWeb/src/org/jmesaweb/controller/CustomToolbar.java).

### Example ###

First start by extending the AbstractToolbar and override the render() method.

```
public class CustomToolbar extends AbstractToolbar {
    @Override
    public String render() {}    
}
```

However this doesn't give you much to start with, so how about if we just drag in the [default](http://code.google.com/p/jmesa/source/browse/trunk/jmesa/src/org/jmesa/view/html/toolbar/HtmlToolbar.java) toolbar items first. _Note: you can, of course, just bring in what you want. Typically when I create a new toolbar item I know exactly what functionality I need and just include the items I need._

```
@Override
public String render() {
   if (hasToolbarItems()) { // already has items
        return super.render();
    }
    
    addToolbarItem(ToolbarItemType.FIRST_PAGE_ITEM);
    addToolbarItem(ToolbarItemType.PREV_PAGE_ITEM);

    ...

    return super.render();
}
```

Now we need to create our new toolbar item. For that we need to implement the ToolbarItem and ToolbarItemRenderer interfaces.

#### ToolbarItem ####

For a toolbar item that displays an image we can get some help from the special ToolbarItem called the ImageItem. The tooltip, image and alt are all used to define the <img> element. The code is used to identify the toolbar item from the other items.<br>
<br>
<pre><code>ImageItem item = new ImageItem();<br>
item.setCode("custom-item");<br>
item.setTooltip("Hello World");<br>
item.setImage(getImage("custom.png", getWebContext(), getCoreContext()));<br>
item.setAlt("custom");<br>
</code></pre>

<h4>ToolbarItemRenderer</h4>

The toolbar item renderer is built by extending the AbstractItemRenderer and overriding the render method. You can think of the renderer as containing the information to render different toolbar items.<br>
<br>
<pre><code>public class CustomItemRenderer extends AbstractItemRenderer {<br>
    public CustomItemRenderer(ToolbarItem item, CoreContext coreContext) {<br>
        setToolbarItem(item);<br>
        setCoreContext(coreContext);<br>
    }<br>
<br>
    @Override<br>
    public String render() {<br>
        ToolbarItem item = getToolbarItem();<br>
        StringBuilder action = new StringBuilder("javascript:");<br>
        action.append("alert('Hello World')");<br>
        item.setAction(action.toString());<br>
        return item.enabled();<br>
    }<br>
}<br>
</code></pre>

Now bring the toolbar item and renderer together.<br>
<br>
<pre><code>ToolbarItemRenderer renderer = new CustomItemRenderer(item, getCoreContext());<br>
renderer.setOnInvokeAction("onInvokeAction");<br>
item.setToolbarItemRenderer(renderer);<br>
</code></pre>

Lastly, add the toolbar item to the toolbar defined in the abstract toolbar you extended.<br>
<br>
<pre><code>addToolbarItem(item);<br>
</code></pre>

<h4>Plug into TableFacade</h4>

To use your custom toolbar you will need to plug it into your TableModel.<br>
<br>
<h5>API</h5>

<pre><code>tableModel.setToolbar(new CustomToolbar());<br>
</code></pre>

<h5>JSP Tag</h5>

<pre><code>&lt;jmesa:tableModel toolbar="com.mycompany.table.CustomToolbar"&gt;<br>
</code></pre>