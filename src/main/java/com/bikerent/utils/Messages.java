package com.bikerent.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Usuário adicionado com sucesso"),
    MESSAGE_2("Esse e-mail já está cadastrado"),
    MESSAGE_3("Usuário não encontrado"),
    MESSAGE_4("E-mail ou senha incorreta"),
    MESSAGE_5("Bicicleta não encontrada"),
    MESSAGE_6("Bicicleta indisponível"),
    MESSAGE_7("Bicicleta liberada para uso"),
    MESSAGE_8("O código informado é inválido"),
    MESSAGE_9("Token inválido");

    private final String description;

}
