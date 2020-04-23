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
@Runtime(javaDelegateClass = "org.acme.runtime.AcmeMoneyJavaDelegation")
@Help(displayHelpShort = "Creates a new account", displayHelpLong =
    "Creates a new account using the account number specified")
public class SensorTask extends AbstractCustomServiceTask {

  private static final String HELP_ACCOUNT_NUMBER_LONG =
      "Provide a number that is suitable as an account number.";

  @Property(type = PropertyType.TEXT, displayName = "Device Name", required = true)
  @Help(displayHelpShort = "Provide an account number", displayHelpLong = HELP_ACCOUNT_NUMBER_LONG)
  private String sensorName;
  
  @Property(type = PropertyType.TEXT, displayName = "Device Source", required = true)
  @Help(displayHelpShort = "Provide an account number", displayHelpLong = HELP_ACCOUNT_NUMBER_LONG)
  private String sensorSource;
  
  @Property(type = PropertyType.TEXT, displayName = "Device Position")
  @Help(displayHelpShort = "Provide an account number", displayHelpLong = HELP_ACCOUNT_NUMBER_LONG)
  private String sensorGeolocalization;

  @Property(type = PropertyType.MULTILINE_TEXT, displayName = "Comments")
  @Help(displayHelpShort = "Provide comments", displayHelpLong =
      "You can add comments to the node to provide a brief description.")
  private String comments;

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