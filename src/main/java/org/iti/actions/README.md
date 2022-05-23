># Actions Class

>> ## _Browser Actions_
This Class implements the initialization of the Webdriver and the actions that can be performed on the Webdriver Level.

```
    initDriver()
    closeDriver()
```


>> ## _WebUi Actions_
This Class implements the Common Methods which Page Objects Use :
### Examples

```
    protected abstract void selectItemInDropdown(By ByElement, String value);
```
```
    protected abstract void selectItemInDropdown(By ByElement, int index);
```
```
    protected abstract void clickOn(By ByElement);
```
```
      etc ... 
```

, Also Contains : ``getInstance`` method  Using JAVA Generics it takes any Class name By any type and create an instance of that class . 

```
    public <NeededPage extends UiActions> NeededPage getInstance(Class<NeededPage> pageNeeded) {
        try {
            return pageNeeded.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
```