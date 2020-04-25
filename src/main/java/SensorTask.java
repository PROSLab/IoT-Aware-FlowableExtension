import org.activiti.designer.integration.annotation.Help;
import org.activiti.designer.integration.annotation.Property;
import org.activiti.designer.integration.servicetask.AbstractCustomServiceTask;
import org.activiti.designer.integration.servicetask.PropertyType;
import org.activiti.designer.integration.annotation.Runtime;

/**
 * @author Ivan Compagnucci
 * @version 1
 * @since 1.0.0
 */
@Runtime(javaDelegateClass = "delegateClasses.sensorDelegate")
@Help(displayHelpShort = "This is the sensor task", displayHelpLong =
    "Define the parameters for receive data from a sensor")
public class SensorTask extends AbstractCustomServiceTask {

  @Property(type = PropertyType.TEXT, displayName = "Device Name", required = true)
  @Help(displayHelpShort = "Provide the name of the device", displayHelpLong = "Insert the name of device")
  public String sensorName;
  
  @Property(type = PropertyType.TEXT, displayName = "Device Source", required = true)
  @Help(displayHelpShort = "Provide a source of the device's data", displayHelpLong = "Insert the device source")
  public String sensorSource;
  
  @Property(type = PropertyType.TEXT, displayName = "Device Position")
  @Help(displayHelpShort = "Provide a position of the device", displayHelpLong = "Insert the device location")
  public String sensorGeolocalization;

  @Override
  public String contributeToPaletteDrawer() {
    return "IoT-Aware Extensions";
  }

  @Override
  public String getName() {
    return "Sensor Task ";
  }

  @Override
  public String getSmallIconPath() {
    return "icons/sensor.png";
  }
  
  @Override
  public String getShapeIconPath() {
    return "icons/sensor.png";
  }
  
  @Override
  public String getLargeIconPath() {
    return "icons/sensor.png";
  }
}