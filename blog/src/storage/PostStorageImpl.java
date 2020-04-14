package storage;


import exception.PostNotFoundException;
import model.Post;

public class PostStorageImpl implements PostStorage {
    private Post[] posts = new Post[10];
    private int size = 0;


    @Override
    public void add(Post post) {
        if (size == posts.length) {
            extend();
        }
        posts[size++] = post;

    }


    public Post getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(title)) {
                return posts[i];
            }
        }
        throw new PostNotFoundException("does not exist");
    }

    @Override
    public void searchPostsByKeyword(String keyword) {
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().contains(keyword) || posts[i].getText().contains(keyword)) {
                System.out.println(posts[i]);
            } else {
                tmp = 1;
            }
        }

        if (tmp == 1 || size == 0) {
            System.out.println("not found");
        }
    }

    @Override
    public void printAllPosts() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);

        }

    }

    @Override
    public void printPostsByCategory(String category) {
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(category) || posts[i].getText().equals(category)) {
                System.out.println(posts[i]);
            } else {
                tmp = -1;
            }
        }
        if (tmp == -1 || size == 0) {
            System.out.println("not found");
        }
    }

    private void extend() {
        Post[] tmp = new Post[posts.length + 10];
        System.arraycopy(posts, 0, tmp, 0, posts.length);
    }
}