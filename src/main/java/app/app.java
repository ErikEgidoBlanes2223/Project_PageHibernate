package app;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import DAO.AutorDao;
import Model.Autor;

public class app {

    public static void main(String[] args) {

    	AutorDao AutorDao = new AutorDao();


            int pageSize = 12;
            int currentPage = 1;
            int totalPages = getTotalPages(AutorDao, pageSize);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("-------- Menu --------");
                System.out.println("<S> - Siguiente");
                System.out.println("<A> - Anterior");
                System.out.println("<G page> - Ir a la pagina");
                System.out.println("<Q> - Salir");

                String userInput = scanner.nextLine().toUpperCase();

                switch (userInput) {
                    case "S":
                        if (currentPage < totalPages) {
                            currentPage++;
                            displayPage(AutorDao, currentPage, pageSize);
                        } else {
                            System.out.println("Ya estás en la última página.");
                        }
                        break;
                    case "A":
                        if (currentPage > 1) {
                            currentPage--;
                            displayPage(AutorDao, currentPage, pageSize);
                        } else {
                            System.out.println("Ya estás en la primera página.");
                        }
                        break;
                    case "Q":
                        System.out.println("Programa finalizado.");
                        System.exit(0);
                    default:
                        if (userInput.startsWith("G ")) {
                            try {
                                int pageNumber = Integer.parseInt(userInput.substring(2).trim());
                                if (pageNumber >= 1 && pageNumber <= totalPages) {
                                    currentPage = pageNumber;
                                    displayPage(AutorDao, currentPage, pageSize);
                                } else {
                                    System.out.println("Número de página inválido.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Ingresa un número después de 'G'.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Inténtalo de nuevo.");
                        }
                }
            }
        }

        private static int getTotalPages(AutorDao AutorDao, int pageSize) {
            List <Autor>allVideojuegos = (List<Autor>) AutorDao.getAutorsPaginados(1, Integer.MAX_VALUE);
            return (int) Math.ceil((double) allVideojuegos.size() / pageSize);
        }

        private static void displayPage(AutorDao AutorDao, int currentPage, int pageSize) {
            List<Autor> llistaAutors = (List<Autor>) AutorDao.getAutorsPaginados(currentPage, pageSize);

            System.out.println("-------- Página " + currentPage + " de " + getTotalPages(AutorDao, pageSize) + " --------");
            for (Autor autor : llistaAutors) {
                System.out.println(autor.toString());
            }
        }
    }
