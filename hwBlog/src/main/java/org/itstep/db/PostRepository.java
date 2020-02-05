package org.itstep.db;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;


public class PostRepository {
    private int id=0;
    CopyOnWriteArrayList<Post> posts;

    public void setId(int id) {
        this.id = id;
    }

    public  int getId() {
        return id;
    }

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

    public void save(Post post){

        posts.add(post);
    }

    private void init() {
        posts.add(Post.builder().title("Перый пост")
                .id(++id)
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());
        posts.add(Post.builder().title("Второй пост")
                .id(++id)
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());
        posts.add(Post.builder().title("Третий пост")
                .id(++id)
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());
    }
    public void delete(int id){
        for(Post p: posts){
            if(id==(p.getId())){
                posts.remove(p);
            }
        }
    }
    public void edit(int id,String newTitle,String newContent){
        for (Post p: posts){
            if (id==(p.getId())){
                if(!"".equals(newTitle)){
                    p.setTitle(newTitle);
                }else {
                    p.setTitle(p.getTitle());
                }
                if(!"".equals(newContent)){
                    p.setContent(newContent);
                }else {
                    p.setContent(p.getContent());
                }
                p.setId(p.getId());
            }
        }
    }

}
