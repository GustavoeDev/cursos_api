package br.com.gustavoedev.cursos_api.modules.courses.exceptions;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() { super("Curso não encontrado!"); }

    public CourseNotFoundException(String message) { super(message); }

}
