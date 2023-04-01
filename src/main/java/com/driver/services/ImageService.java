package com.driver.services;

import com.driver.Exception.BlogNotFoundException;
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

    public Image addImage(Integer blogId, String description, String dimensions) throws BlogNotFoundException {
        //add an image to the blog
        Blog blog;
        try{
            blog = blogRepository2.findById(blogId).get();
        }catch (Exception e){
            throw new BlogNotFoundException("Invalid blog id");
        }


        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);
//        imageRepository2.save(image);
        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blogRepository2.save(blog);
        return image;
    }


    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] screeDimensionArr = screenDimensions.split("X");
        int screenDimensionsInt = Integer.parseInt(screeDimensionArr[0]) * Integer.parseInt(screeDimensionArr[1]);

        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String[] imageDimensionArr = imageDimensions.split("X");
        int imageDimensionsInt = Integer.parseInt(imageDimensionArr[0]) * Integer.parseInt(imageDimensionArr[1]);
        int noOfImages = screenDimensionsInt/imageDimensionsInt;
        return noOfImages;
    }



    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }
}
