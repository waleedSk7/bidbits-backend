package com.waleed.oopsproject.Messages;

import com.waleed.oopsproject.Products.ProductModel;
import com.waleed.oopsproject.Users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Long> {


    public Iterable<MessageModel> findAllByProductId(Long productId);

    Iterable<MessageModel> findAllBySender(UserModel sender);

    Iterable<MessageModel> findAllByProduct(ProductModel product);
}
