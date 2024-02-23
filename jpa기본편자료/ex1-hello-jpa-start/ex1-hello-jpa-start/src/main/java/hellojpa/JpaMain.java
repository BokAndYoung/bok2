package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        try {
            // 등록
//            registerMember(em, 1L, "hio");
//
//            // 전체 멤버 조회
//            List<Member> members = findAllMembers(em);
//            //한번해보쇼 ㅋㅋ
//            System.out.println("Members list:");
//            for (Member member : members) {
//                System.out.println(member.getId() + member.getName());
//            }

            // 조회
            Member foundMember = findMember(em, 102L);
            System.out.println("Found member: " + foundMember.getName());


//            // 수정
//            updateMember(em, 1L, "updatedName");
//
//            // 삭제
//            deleteMember(em, 1L);

        } finally {
            em.close();
            emf.close();
        }
    }

    public static void registerMember(EntityManager em, Long id, String name) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Member member = new Member();
            member.setId(id);
            member.setName(name);
            em.persist(member);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

    public static Member findMember(EntityManager em, Long id) {
        return em.find(Member.class, id);
    }

    public static List<Member> findAllMembers(EntityManager em) {
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
        return query.getResultList();
    }

    public static void updateMember(EntityManager em, Long id, String newName) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Member member = em.find(Member.class, id);
            member.setName(newName);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

    public static void deleteMember(EntityManager em, Long id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Member member = em.find(Member.class, id);
            em.remove(member);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
