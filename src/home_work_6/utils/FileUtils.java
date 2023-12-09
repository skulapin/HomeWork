package home_work_6.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Утилита для работы с чтением и записью файлов
 */
public class FileUtils {
	/**
	 * Считывает текстовый файл и возвращает текст в формате String
	 * 
	 * @param path Путь к текстовому файлу
	 * @param splitter Разделитель для строк. Возможные варианты: " ", "\n"
	 * @return Текст файла в формате String
	 * @throws IOException При проблеме считывания файла
	 */
	public static String readFromFile(String path, String splitter) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(path));
		StringBuilder builder = new StringBuilder();

		String line;
		boolean needSplitter = false;

		while ((line = reader.readLine()) != null) {
			if (needSplitter) {
				builder.append(splitter);
			}
			builder.append(line);
			needSplitter = true;
		}
		reader.close();
		return builder.toString();
	}

	/**
	 * Записывает информацию в файл. При наличии текста в файле производит
	 * дозаписывание информации
	 * 
	 * @param line     Текст для записи
	 * @param fileName Имя файла куда записываем
	 * @return true - запись произошла успешно false - запись произошла неудачно
	 * @throws IOException При проблеме с записью файла
	 */
	public static boolean writeToFile(String line, String fileName) throws IOException {

		Writer writer = new FileWriter(fileName, true);

		writer.write(line + "\n");
		writer.flush();
		writer.close();
		return true;
	}

	/**
	 * Формирует коллекцию строк, состаящую из файлов по переданной директории.
	 * Папки при поиске игнорируются
	 * 
	 * @param path      Путь для поиска файлов
	 * @param extension Расширение файлов. При переданном null или пустой строке в
	 *                  строку попадают все файлы
	 * @return коллекция с названиями файлов
	 */
	public static List<String> getFilesList(String path, String extension) {

		List<String> list = new ArrayList<>();
		int extLength = extension.length();

		if (extension != null || !"".equals(extension)) {

			int counter = 0;
			int index = 0;
			while ((index = extension.indexOf('.', index)) != -1) {
				counter++;
				index++;
			}

			// проверка на корректность переданного расширения файла
			if (extLength < 3 || extLength > 5 || extension.charAt(0) != '.' || counter > 1) {
				return list;
			}
		}

		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (file.isFile()) {
				String tempBookName = file.getName();
				if (extension == null || "".equals(extension) || tempBookName.endsWith(extension)) {
					list.add(tempBookName);
				}
			}
		}
		return list;
	}
}
