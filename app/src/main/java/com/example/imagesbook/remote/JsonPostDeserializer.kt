package com.example.imagesbook.remote

import com.example.imagesbook.model.Post
import com.example.imagesbook.model.Posts
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class JsonPostDeserializer : JsonDeserializer<Posts>{
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Posts {
        var posts = Posts()
        var title = ""
        var image = ""
        if (json != null) {
            if(json.isJsonObject) {
                for(entry in json.asJsonObject.entrySet()) {
                    if (entry.key == "title") {
                        title = entry.value.toString()
                    } else if(entry.key == "image") {
                        image = entry.value.toString()
                    }
                    val post = Post(title, image)
                    posts.addPost(post)
                }
            }
        }
        return posts
    }

}