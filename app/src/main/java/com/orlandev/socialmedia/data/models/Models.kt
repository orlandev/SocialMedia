package com.orlandev.socialmedia.data.models

import kotlin.random.Random

data class User(
    val name: String,
    val avatar: String,
    val bannerImage: String = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/posters/image_${
        Random.nextInt(
            1,
            8
        )
    }.jpg",
    val fallowers: Int = Random.nextInt(100, 9999),
    val instagram: String = name.replace(" ", ".").lowercase(),
    val work: String = listOf(
        "Waiter",
        "Paramedic",
        "Dentist",
        "Train conductor",
        "Nurse",
        "Electrician",
        "Doctor",
        "Businessman",
        "American football player",
        "Student",
        "Surgeon",
        "Doorman",
        "Secretary",
        "Soldier",
        "Repairman",
        "Scientist",
        "Reporter",
        "Construction worker",
        "Professor",
        "Police officer",
        "Postman",
        "Photographer",
        "Pilot",
        "Catholic nun",
        "Painter",
        "Mechanic",
        "Magician",
        "Lifeguard",
        "Lunchroom supervisor",
        "Clown",
        "Housekeeper",
        "Gardener",
        "Geisha",
        "Footballer",
        "Forest ranger",
        "Builder",
        "Foreman",
        "Farmer",
        "Flight attendant",
        "Fireman",
        "Engineer",
        "Carpenter",
        "Architect",
        "Boxer",
        "Cameraman",
        "Detective",
        "Journalist",
        "Housewife",
        "Diver",
        "Pope",
        "Priest",
        "Salesman",
        "Librarian",
        "Pirate",
        "Singer"
    ).random(),
    val friends: List<Friends>,
    val address: String,
) {

}

data class Friends(
    val name: String,
    val avatar: String,
) {
    companion object {
        val mock = listOf(
            Friends(
                name = "Carlos Ernesto",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_5.jpg"
            ),
            Friends(
                name = "Ivan Rodriguez",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_4.jpg"
            ),
            Friends(
                name = "Esther Kintana",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_8.jpg"
            ),
            Friends(
                name = "Carmen Perez",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_1.jpg"
            ),
            Friends(
                name = "Luis Fidel Casanova",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_3.jpg"
            ),
        )

        fun randomList(): List<Friends> {
            val list = mutableSetOf<Friends>()
            repeat(Random.nextInt(3, 5)) {
                list.add(mock.random())
            }
            return list.toList()
        }
    }
}


data class UserList(
    val users: List<User>
) {
    companion object {
        val mock = listOf(
            User(
                name = "Sophia Ferreira",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_1.jpg",
                address = "Rio de Janeiro, Brazil",
                friends = Friends.randomList(),
            ),
            User(
                name = "Mariano Rodriguez",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_2.jpg",
                address = "Rio de Janeiro, Brazil",
                friends = Friends.randomList(),
            ),

            User(
                name = "Luis Graham",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_3.jpg",
                address = "New York, USA",
                friends = Friends.randomList(),
            ),

            User(
                name = "Aadan Contee",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_4.jpg",
                address = "Dodoma, Tanzania",
                friends = Friends.randomList(),
            ),
            User(
                name = "Carlos Betancour",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_5.jpg",
                address = "Dodoma, Tanzania",
                friends = Friends.randomList(),
            ),

            User(
                name = "Rio Rosales",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_6.jpg",
                address = "Medellin, Colombia",
                friends = Friends.randomList(),
            ),

            User(
                name = "Leanne Graham",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_7.jpg",
                address = "New York, USA",
                friends = Friends.randomList(),
            ),
            User(
                name = "Clara Dubois",
                avatar = "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/avatars/avatar_8.jpg",
                address = "Paris, Francia",
                friends = Friends.randomList(),
            ),
        )
    }
}


data class Poster(
    val posterText: String,
    val posterImage: List<String>,
    val user: User,
    val time: String
)


data class PostersList(
    val list: List<Poster>
) {
    companion object {
        private val listOfPostersText = listOf<String>(

            "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
            """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat 
                non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            """.trimIndent()
        )

        private val lisOfPosterImages = (1..Random.nextInt(1, 8)).map {
            "https://ik.imagekit.io/6xgh00mrhaz/SocialMedia/posters/image_$it.jpg"
        }.shuffled()

        val mock = (1..10).map {
            Poster(
                posterText = listOfPostersText.random(),
                posterImage = lisOfPosterImages,
                user = UserList.mock.random(),
                time = "${Random.nextInt(10, 60)} m"
            )
        }
    }
}





