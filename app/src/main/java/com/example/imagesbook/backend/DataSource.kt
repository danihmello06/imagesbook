package com.example.imagesbook.backend

import com.example.imagesbook.backend.model.Post

class DataSource {

    companion object {

        fun createDataSet(): ArrayList<Post> {
            val list = ArrayList<Post>()
            list.add(
                Post (
                    "Titulo",
                    "Corpo",
                    "https://raw.githubusercontent.com/danihmello06/imagesbook/master/app/src/main/res/drawable/imagem1.jpg",
                    "Autor"
                )
            )
            list.add(
                Post (
                    "Titulo",
                    "Corpo",
                    "https://raw.githubusercontent.com/danihmello06/imagesbook/master/app/src/main/res/drawable/imagem2.png",
                    "Autor"
                )
            )
            list.add(
                Post (
                    "Titulo",
                    "Corpo",
                    "https://raw.githubusercontent.com/danihmello06/imagesbook/master/app/src/main/res/drawable/imagem3.png",
                    "Autor"
                )
            )
            list.add(
                Post (
                    "Titulo",
                    "Corpo",
                    "https://raw.githubusercontent.com/danihmello06/imagesbook/master/app/src/main/res/drawable/imagem4.png",
                    "Autor"
                )
            )
            list.add(
                Post (
                    "Titulo",
                    "Corpo",
                    "https://raw.githubusercontent.com/danihmello06/imagesbook/master/app/src/main/res/drawable/imagem5.png",
                    "Autor"
                )
            )
            list.add(
                Post (
                    "Titulo",
                    "Corpo",
                    "https://raw.githubusercontent.com/danihmello06/imagesbook/master/app/src/main/res/drawable/imagem6.png",
                    "Autor"
                )
            )
            list.add(
                Post (
                    "Titulo",
                    "Corpo",
                    "https://raw.githubusercontent.com/danihmello06/imagesbook/master/app/src/main/res/drawable/imagem7.jpg",
                    "Autor"
                )
            )
            return list
        }

    }

}