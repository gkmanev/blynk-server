package cc.blynk.server.model.widgets;

import cc.blynk.server.model.HardwareBody;
import cc.blynk.server.model.enums.PinType;
import cc.blynk.server.model.enums.State;
import cc.blynk.server.model.widgets.controls.*;
import cc.blynk.server.model.widgets.inputs.GPS;
import cc.blynk.server.model.widgets.notifications.Mail;
import cc.blynk.server.model.widgets.notifications.Notification;
import cc.blynk.server.model.widgets.notifications.Twitter;
import cc.blynk.server.model.widgets.others.Bluetooth;
import cc.blynk.server.model.widgets.others.Bridge;
import cc.blynk.server.model.widgets.others.RCT;
import cc.blynk.server.model.widgets.outputs.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * User: ddumanskiy
 * Date: 21.11.13
 * Time: 13:08
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({

        //controls
        @JsonSubTypes.Type(value = Button.class, name = "BUTTON"),
        @JsonSubTypes.Type(value = Slider.class, name = "SLIDER"),
        @JsonSubTypes.Type(value = RGB.class, name = "RGB"),
        @JsonSubTypes.Type(value = Timer.class, name = "TIMER"),
        @JsonSubTypes.Type(value = OneAxisJoystick.class, name = "ONE_AXIS_JOYSTICK"),
        @JsonSubTypes.Type(value = TwoAxisJoystick.class, name = "TWO_AXIS_JOYSTICK"),
        @JsonSubTypes.Type(value = Terminal.class, name = "TERMINAL"),

        //outputs
        @JsonSubTypes.Type(value = LED.class, name = "LED"),
        @JsonSubTypes.Type(value = Digit4Display.class, name = "DIGIT4_DISPLAY"),
        @JsonSubTypes.Type(value = Gauge.class, name = "GAUGE"),
        @JsonSubTypes.Type(value = LCD.class, name = "LCD"),
        @JsonSubTypes.Type(value = Graph.class, name = "GRAPH"),
        @JsonSubTypes.Type(value = LevelDisplay.class, name = "LEVEL_DISPLAY"),

        //inputs
        @JsonSubTypes.Type(value = GPS.class, name = "GPS"),

        //notifications
        @JsonSubTypes.Type(value = Twitter.class, name = "TWITTER"),
        @JsonSubTypes.Type(value = Mail.class, name = "EMAIL"),
        @JsonSubTypes.Type(value = Notification.class, name = "NOTIFICATION"),

        //others
        @JsonSubTypes.Type(value = RCT.class, name = "RCT"),
        @JsonSubTypes.Type(value = Bridge.class, name = "BRIDGE"),
        @JsonSubTypes.Type(value = Logger.class, name = "LOGGER"),
        @JsonSubTypes.Type(value = Bluetooth.class, name = "BLUETOOTH")

})
public abstract class Widget {

    public long id;

    public int x;

    public int y;

    public Integer color;

    public Integer width;

    public Integer height;

    public String label;

    //todo is it used?
    public State state;

    public abstract void updateIfSame(HardwareBody body);

    public abstract boolean isSame(byte pin, PinType type);

    public abstract String getValue(byte pin, PinType type);

}
