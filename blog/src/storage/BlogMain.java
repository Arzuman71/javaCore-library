package storage;

import exception.PostNotFoundException;
import model.Post;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Comands {
    private static Scanner scanner = new Scanner(System.in);
    private static PostStorageImpl postStorage = new PostStorageImpl();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            prindCommands();
            int commands;
            try {
                commands = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
                commands = -1;
            }
            switch (commands) {
                case EXIT:
                    isRun = false;
                    System.out.println("Come again");
                    break;
                case ADD_POST:
                    AddPost();
                    break;
                case SEARCH_POST:
                    SearchPost();
                    break;
                case POSTS_BY_CATEGORY:
                    String category = scanner.nextLine();
                    postStorage.printPostsByCategory(category);
                    break;
                case ALL_POSTS:
                    postStorage.printAllPosts();
                    break;
                case SEARCH_BY_TITLE:
                    SearchByTitle();

                    break;
                default:
                    System.out.println("sxal es gre");
            }
        }
    }

    private static void SearchByTitle() {
        try {
            String title = scanner.nextLine();
            System.out.println(postStorage.getPostByTitle(title));
        } catch (PostNotFoundException e) {
            System.out.println("wrong name");
            SearchByTitle();
        }
    }

    private static void SearchPost() {
        System.out.println("write please");
        String Keyword = scanner.nextLine();
        postStorage.searchPostsByKeyword(Keyword);
    }

    private static void AddPost() {
        try {
            System.out.println("title, text, categorye");
            String post = scanner.nextLine();
            String[] postMember = post.split(",");
            String title = postMember[0];
            String texe = postMember[1];
            String category = postMember[2];
            Date date = new Date();

            Post post1 = new Post(title, texe, category, date);
            postStorage.add(post1);
            System.out.println("your post has been added");

        } catch (NumberFormatException e) {
            System.out.println("or added a lot or a little");
            AddPost();
        }

    }

    private static void prindCommands() {
        System.out.println("for EXIT " + EXIT);
        System.out.println("for ADD POST " + ADD_POST);
        System.out.println("SEARCH POST " + SEARCH_POST);
        System.out.println("POSTS BY CATEGORY " + POSTS_BY_CATEGORY);
        System.out.println("ALL POSTS " + ALL_POSTS);
        System.out.println("SEARCH BY TITLE " + SEARCH_BY_TITLE);
    }
}
