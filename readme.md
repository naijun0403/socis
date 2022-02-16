# Socis
remote-kakao for java/kotlin (Unoffical)

## Client Example
See [here](https://github.com/remote-kakao/core-client/releases)

## Server Example
### Java
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

### Kotlin
```kotlin
class EventListenerTest : EventListenerService() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val client = SocisClient()
            client.addListener(EventListenerTest())
            println("ready")
            client.start();
            println("start")
        }
    }

    override fun onMessage(event: MessageEvent) {
        if (event.message == "!ping") {
            event.channel.sendMessage("pong!")
        }
    }
}
```
