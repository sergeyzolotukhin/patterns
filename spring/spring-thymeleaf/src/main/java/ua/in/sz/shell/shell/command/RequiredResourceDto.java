package ua.in.sz.shell.shell.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequiredResourceDto {
    private String id;
    private int amount;
}
