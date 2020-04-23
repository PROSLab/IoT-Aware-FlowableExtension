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
    "Define the response for the actuation")
public class ActuatorTask extends AbstractCustomServiceTask {

  private static final String HELP_ACCOUNT_NUMBER_LONG =
      "Provide a number that is suitable as an account number.";

  @Property(type = PropertyType.TEXT, displayName = "Device Name", required = true)
  @Help(displayHelpShort = "Provide an account number", displayHelpLong = HELP_ACCOUNT_NUMBER_LONG)
  private String accountNumber;

  @Property(type = PropertyType.MULTILINE_TEXT, displayName = "Response", required = true)
  @Help(displayHelpShort = "Provide response", displayHelpLong =
      "Add the response for the actuation")
  private String comments;

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