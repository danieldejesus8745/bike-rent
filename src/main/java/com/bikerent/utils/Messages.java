package com.bikerent.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Usuário adicionado com sucesso"),
    MESSAGE_2("Esse e-mail já está cadastrado"),
    MESSAGE_3("Usuário não encontrado"),
    MESSAGE_4("E-mail ou senha incorreta");

    private final String description;

}
