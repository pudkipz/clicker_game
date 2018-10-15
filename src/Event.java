public class Event {
    public enum Type {
        PANE1_BTN,
        PANE2_BTN
    }

    public final Event.Type type;
    public final Object data;

    public Event(Event.Type type, Object data) {
        this.type = type;
        this.data = data;
    }

    public Event(Event.Type type) {
        this(type, null);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
