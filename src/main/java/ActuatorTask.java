import org.activiti.designer.integration.annotation.Help;
import org.activiti.designer.integration.annotation.Property;
import org.activiti.designer.integration.annotation.PropertyItems;
import org.activiti.designer.integration.servicetask.AbstractCustomServiceTask;
import org.activiti.designer.integration.servicetask.PropertyType;
import org.activiti.designer.integration.annotation.Runtime;

/**
 * @author Ivan Compagnucci
 * @version 1
 * @since 1.0.0
 */
@Runtime(javaDelegateClass = "delegateClasses.actuatorDelegate")
@Help(displayHelpShort = "This is the actuator task", displayHelpLong =
    "Define the parameters for the actuation")
public class ActuatorTask extends AbstractCustomServiceTask {

  private static final String MQTT = null;
  private static final String HTTP = null;

@Property(type = PropertyType.TEXT, displayName = "Device Name", required = true)
  @Help(displayHelpShort = "Provide the name of the device", displayHelpLong = "Insert the name of device")
  private String actuatorName;
  
  @Property(type = PropertyType.TEXT, displayName = "Response type", required = true)
  @Help(displayHelpShort = "Provide response type for the device ", displayHelpLong ="Add the response type for the actuation")
  private String responseTyped;

  @Property(type = PropertyType.TEXT, displayName = "Response source", required = true)
  @Help(displayHelpShort = "Provide a target source for the device ", displayHelpLong ="Add the response for the actuation")
  private String targetSource;
  
  @Property(type = PropertyType.MULTILINE_TEXT, displayName = "Content of Response (in JSON)", required = true)
  @Help(displayHelpShort = "Provide response for the device ", displayHelpLong ="Add the response for the actuation")
  private String responseString;
  
  @Override
  public String contributeToPaletteDrawer() {
    return "IoT-Aware Extensions";
  }

  @Override
  public String getName() {
    return "Actuator Task ";
  }

  @Override
  public String getSmallIconPath() {
    return "icons/actuator.png";
  }
  
  @Override
  public String getShapeIconPath() {
    return "icons/actuator.png";
  }
  
  @Override
  public String getLargeIconPath() {
    return "icons/actuator.png";
  }
 
}