package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image(description,dimensions,blog);
        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blogRepository2.save(blog);
        return image;
    }


    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] screeDimensionArr = screenDimensions.split("X");


        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String[] imageDimensionArr = imageDimensions.split("X");
        int length = Integer.parseInt(screeDimensionArr[0])/Integer.parseInt(imageDimensionArr[0]);
        int breadth = Integer.parseInt(screeDimensionArr[1]) / Integer.parseInt(imageDimensionArr[1]);
        int noOfImages = length * breadth;
        return noOfImages;
    }



    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }
}
