# Socis
remote-kakao for java (Unoffical)

## Client Example
See [here](https://github.com/remote-kakao/example)

## Server Example
```java
public class EventListenerTest extends EventListenerService {
    public static void main(String[] args) {
        SocisClient client = new SocisClient();
        System.out.println("ready");
        client.addListener(new EventListenerTest());
        client.start();
        System.out.println("start");
    }

    @Override
    public void onMessage(MessageEvent event) {
        if (event.getMessage().equals("!ping")) {
            event.getChannel().sendMessage("pong!");
        }
    }
}
```
