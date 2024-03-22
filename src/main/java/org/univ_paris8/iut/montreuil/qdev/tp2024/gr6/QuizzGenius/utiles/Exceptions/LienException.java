package org.univ_paris8.iut.montreuil.qdev.tp2024.gr6.QuizzGenius.utiles.Exceptions;

import java.io.FileNotFoundException;

public class LienException extends FileNotFoundException{
    public LienException(String errorMessage) {
        super(errorMessage);
    }
    public LienException() {
        super();
    }
}
