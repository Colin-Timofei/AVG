package md.tekwill.main.test;

import md.tekwill.domain.Employee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static md.tekwill.dao.generator.Generator.*;

public class Test
{
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu kk:mm");

        System.out.println(LocalDateTime.now().format(formatter));
    }

}