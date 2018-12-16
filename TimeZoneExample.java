
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
public class TimeZoneExample {


    public static void main(String[] args) {
        Instant now = Instant.now();
        List<String> zones = ZoneId.getAvailableZoneIds().stream()
                .map(id -> now.atZone(ZoneId.of(id)))
                .sorted(comparingInt(zoneId ->
                        zoneId.getOffset().getTotalSeconds()))
                .map(zonedDateTime -> zonedDateTime.getZone().getId())
                .collect(Collectors.toList());

        int index1 = zones.indexOf("US/Hawaii");

        int index2 = zones.indexOf("US/Alaska");

        List<String> ids = zones.subList(index1+1, index2);

        ids.stream().forEach(s -> {
            System.out.println(s);
        });

    }
}
