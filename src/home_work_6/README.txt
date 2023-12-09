WarAndPeaceRunner - Task1, 2, 5
WordFinderMultiThreadRunner - Task8
WordFinderRunner - Task7
	api:
		ISearchEngine - Task3
	callable:
		WordSearchJob - реализация интерфейса Callable
	comparator:
		KeyStringComparator - Компаратор для лексикографического сравнения ключей
		ValueIntegerComparator - Компаратор для сравнения количества ключей
	search_engines:
		EasySearch - Task4.1
		RegExSearch - Task4.2
		SearchEngineCaseInsensitive - Task4.4
		SearchEngineCaseNormalizer - Task4.5
		SearchEnginePunctuationNormalizer - Task4.3
	utils:
		CollectionUtils - Утилита для работы с коллекциями
		FileUtils - Утилита для работы с чтением и записью файлов
		ParseBookUtils - Утилита для разборки текстового документа на слова