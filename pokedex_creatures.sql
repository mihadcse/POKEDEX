-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pokedex
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `creatures`
--

DROP TABLE IF EXISTS `creatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creatures` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creature_name` varchar(45) NOT NULL,
  `creature_description` text NOT NULL,
  `creature_image` varchar(400) NOT NULL,
  `creature_type` varchar(45) NOT NULL,
  `height` varchar(20) NOT NULL,
  `weight` varchar(20) NOT NULL,
  `prev_gen` varchar(45) NOT NULL,
  `next_gen` varchar(45) NOT NULL,
  `favourite` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`creature_name`),
  UNIQUE KEY `creature_name_UNIQUE` (`creature_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creatures`
--

LOCK TABLES `creatures` WRITE;
/*!40000 ALTER TABLE `creatures` DISABLE KEYS */;
INSERT INTO `creatures` VALUES (1,'Bulbasaur','Bulbasaur is a Grass/Poison type Pokémon introduced in Generation 1.\n\nBulbasaur is a small, mainly turquoise amphibian Pokémon with red eyes and a green bulb on its back. It is based on a frog/toad, with the bulb resembling a plant bulb that grows into a flower as it evolves.\n\nBulbasaur is notable for being the very first Pokémon in the National Pokédex. It is one of the three choices for a starter Pokémon in the original Game Boy games, Pokémon Red & Blue (Red & Green in Japan),\n along with Charmander and Squirtle.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/bulbasaur.jpg','Grass','0.7 m','6.9 kg','N/A','Ivysaur','--'),(2,'Ivysaur','Ivysaur is a Grass/Poison type Pokémon introduced in Generation 1.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/ivysaur.jpg','Grass','1.0 m','13.0 kg ','Bulbasaur','Venusaur','Favourite'),(3,'Venusaur','Venusaur is a Grass/Poison type Pokémon introduced in Generation 1.\n\nVenusaur is a large, quadrupedal Pokémon with a turquoise body. It has small red eyes and several large ferns on its back and head. \nThe plant bulb that was on the back of its previous evolutions, Bulbasaur and Ivysaur, has now bloomed into a large flower with large pink petals and a yellow center. The female has a seed in the center.\n\nVenusaur is inspired by toads and the horned frog. The large flower is similar to the Rafflesia arnoldii, a parasitic plant with an unpleasant odor, referencing the Pokémon\'s Poison type.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/venusaur.jpg','Grass','2.0 m ','100.0 kg','Ivysaur','N/A','Favourite'),(4,'Pikachu','Pikachu is an Electric type Pokémon introduced in Generation 1.\n\nPikachu has a Gigantamax form available in Pokémon Sword/Shield, with \nan exclusive G-Max move, G-Max Volt Crash.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/pikachu.jpg','Electric','0.4 m','6.0 kg','Pichu','Pikachu','Favourite'),(5,'Machoke','Machoke is a Fighting type Pokémon introduced in Generation 1.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/machoke.jpg','FIGHTING','1.5 m ','70.5 kg','Machop','Machamp','--'),(6,'Pichu','Pichu is an Electric type Pokémon introduced in Generation 2.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/pichu.jpg','ELECTRIC','0.3 m','2.0 kg','N/A','Pikachu','Favourite'),(7,'Zapdos','Zapdos is an Electric/Flying type Pokémon introduced in Generation 1.\n\nZapdos has a Galarian Form, introduced in the Crown Tundra Expansion Pass to Pokémon Sword/Shield.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/zapdos.jpg','ELECTRIC FLYING','1.6 m','52.6 kg','N/A','N/A','Favourite'),(8,'Cyndaquil','Cyndaquil is a Fire type Pokémon introduced in Generation 2.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/cyndaquil.jpg','FIRE','0.5 m ','7.9 kg','N/A','Quilava','Favourite'),(9,'Quilava','Quilava is a Fire type Pokémon introduced in Generation 2.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/quilava.jpg','FIRE','0.9 m','19.0 kg','Cyndaquil','Typhlosion','Favourite'),(10,'Totodile','Totodile is a Water type Pokémon introduced in Generation 2.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/totodile.jpg','WATER','0.6 m','9.5 kg','N/A','Croconaw','--'),(11,'Croconaw','Croconaw is a Water type Pokémon introduced in Generation 2.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/croconaw.jpg','WATER','1.1 m','25.0 kg','Totodile','Feraligatr','Favourite'),(12,'Feraligatr','Feraligatr is a Water type Pokémon introduced in Generation 2.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/feraligatr.jpg','WATER','2.3 m','88.8 kg','Croconaw','N/A','--'),(13,'Pansage','Pansage is a Grass type Pokémon introduced in Generation 5.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/pansage.jpg','GRASS','0.6 m','10.5 kg ','N/A','Simisage','--'),(14,'Simisage','Simisage is a Grass type Pokémon introduced in Generation 5.\n\n','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/simisage.jpg','GRASS','1.1 m ','30.5 kg','Pansage','N/A','Favourite'),(15,'Duraludon','Duraludon is a Steel/Dragon type Pokémon introduced in Generation 8.\n\nThe metal composing its body is incredibly durable but also surprisingly light. It only weighs about 88 lbs. in total.\n Thanks to this, Duraludon can move quite quickly in spite of its appearance. Its body is weak to corrosion, however, and is known to rust easily.\n\nDuraludon has a Gigantamax form available in Pokémon Sword/Shield, with an exclusive G-Max move, G-Max Depletion.','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/duraludon.jpg','STEEL DRAGON','1.8 m','40.0 kg ','N/A','Archaludon','--'),(16,'Archaludon','Archaludon is a Steel/Dragon type Pokémon introduced in Generation 9.\n\nEvolution of Duraludon, available in part 2 of the Scarlet/Violet DLC, The Indigo Disk.\n\nWhen in trouble, Archaludon extends its normally bent torso, trading some of its mobility for a more stable centre of gravity.\n While it’s like this, the Pokémon resembles a magnificent steel bridge.\n\n','D:\\IUT SEMESTER 4\\CSE 4402\\Pokedex\\src\\main\\resources\\org\\example\\pokedex/archaludon.jpg','STEEL DRAGON','2.0 m','60.0 kg','Duraludon','N/A','Favourite'),(17,'bdbdjfksd','asdfasfsd','D:\\IUT SEMESTER 4\\CSE 4408/Bangladesh.jpg','sdff','234','23','sdfsd','fdsfsds','--');
/*!40000 ALTER TABLE `creatures` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 11:01:39
