package constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemperatureUnit {
    CELSIUS("C"),
    FAHRENHEIT("F");

    private final String symbol;
}
