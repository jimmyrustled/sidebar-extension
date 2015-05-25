# Dreambot Sidebar
The side plugin system for [DreamBot](http://dreambot.org) aims to provide a centralized location for graphical interfaces that makes it easier for the user to use and manage multiple plugins at a time.

### Usage
All the same methods provided by extending Plugin are provided, so you receive the same functionality in terms of client methods. Additionally, you have access to manipulate the sidebar user interface, including (but not required) the use of side icons, centralized settings, and sidebar scenes.

##### Barebones (No settings, no side icon, no sidebar scene)
```java
@PluginManifest(name="Barbone example", author="jimmyrustled", description="Doesn't do anything", version=0.1)
public class BareboneExample extends SidePlugin {
  @Override
  public void onStart() {
    System.out.println("You started the barebone example side plugin");
  }
  
  @Override
  public int onLoop() {
    System.out.println("barebone example running");
  
    return 5000; //The amount of time before this loop will execute again (in ms)
  }
}
```
Although this scenario doesn't take advantage of any of the extra functinoality of the sidebar extension, it still allows yours a centralized locations to enable and disabl
e their plugins as it will be loaded and handlded through the sidebar and managed through its interface.
