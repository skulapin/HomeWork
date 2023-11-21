Runner - точка входа в приложение
RunnerEngine - класс выполняющий и делегируюший операции над переданной коллекцией
	dto_classes:
	Animal - DTO класс для хранения информации об объектах Animal
	Person - DTO класс для хранения информации об объектах Person
	utils:
		comparators:
		AgeAndNickCompare - компаратор для объектов Animal. Сортирует по возрасту и длине ника
		AgeCompare - компаратор для объектов Animal. Сортирует по возрасту
		PasswordLengthAndNickCompare  - компаратор для объектов Person. Сортирует по длине пароля и нику
		PasswordLengthCompare - компаратор для объектов Person. Сортирует по длине пароля
	CollectionUtils - утилита для операций над коллекциями
	GenerateStringUtils - утилита для генерации строк
	IteratorUtils - утилита для итерации коллекций