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
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        imageRepository2.save(image);
        List<Image> imageList = blog.getImages();
        imageList.add(image);
        blogRepository2.save(blog);
        return image;
    }


    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        int screenDimensionsInt = Integer.parseInt(screenDimensions);

        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        int imageDimensionsInt = Integer.parseInt(imageDimensions);
        int noOfImages = screenDimensionsInt/imageDimensionsInt;
        return noOfImages;
    }



    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }
}
