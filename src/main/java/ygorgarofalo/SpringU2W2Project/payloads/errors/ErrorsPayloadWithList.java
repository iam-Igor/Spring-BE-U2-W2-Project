package ygorgarofalo.SpringU2W2Project.payloads.errors;

import java.util.List;

public record ErrorsPayloadWithList(
        String message,

        List<String> errorsList
) {
}
