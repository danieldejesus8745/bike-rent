package com.bikerent.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Usuário adicionado com sucesso"),
    MESSAGE_2("Esse e-mail já está cadastrado");

    private final String description;

}
