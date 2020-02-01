package org.itstep.db;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepository {
    CopyOnWriteArrayList<Post> posts;

    private static PostRepository instance = new PostRepository();

    private PostRepository() {
        posts = new CopyOnWriteArrayList<>();
        init();
    }

    public static PostRepository getInstance() {
        return instance;
    }

    public CopyOnWriteArrayList<Post> getPosts() {
        return posts;
    }

    private void init() {
        posts.add(Post.builder().title("Post Title")
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());
        posts.add(Post.builder().title("Post Title")
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());
        posts.add(Post.builder().title("Post Title")
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());
    }
}
