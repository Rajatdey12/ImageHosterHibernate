package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;


@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public void  createComment(Comment comment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
    
    public List<Comment> getCommentsForImgUser(Integer imageId, Integer userId) {
        EntityManager em = emf.createEntityManager();
        
       try {
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image.id =:imageId", Comment.class)
        		.setParameter("imageId", imageId);
        List<Comment> resultList = query.getResultList();

        return resultList;
       }
       catch (NoResultException nre){
    	   return null;
       }
    }
}