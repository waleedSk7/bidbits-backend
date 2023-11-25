package com.waleed.oopsproject.Messages;

import com.waleed.oopsproject.Products.ProductModel;
import com.waleed.oopsproject.Products.ProductRepository;
import com.waleed.oopsproject.Users.UserModel;
import com.waleed.oopsproject.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    // Create
    public MessageModel addMessage(MessageModel messageModel, Long productId, Long userId) {
        messageModel.setProduct(productRepository.findById(productId).orElse(null));
        messageModel.setSender(userRepository.findById(userId).orElse(null));
        return messageRepository.save(messageModel);
    }

    // Read
    public Iterable<MessageModel> getMessagesByProductId(Long productId) {
        return messageRepository.findAllByProductId(productId);
    }

    public Iterable<MessageModel> getAllMessages() {
        return messageRepository.findAll();
    }

    // Get Messages by Sender
    public Iterable<MessageModel> getMessagesBySenderId(Long senderId) {
        UserModel sender = userRepository.findById(senderId).orElse(null);
        assert sender != null;
        return messageRepository.findAllBySender(sender);
    }

    // Get Messages by Receiver
    public Iterable<MessageModel> getMessagesByReceiverId(Long receiverId) {
        UserModel receiver = userRepository.findById(receiverId).orElse(null);
        Iterable<ProductModel> products = productRepository.findAllByUser(receiver);
        List<MessageModel> messages = new java.util.ArrayList<>();
        for (ProductModel product : products) {
            messages.addAll((List<MessageModel>) messageRepository.findAllByProduct(product));
        }
        return messages;
    }
}
