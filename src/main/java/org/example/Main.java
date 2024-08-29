// Проверка кода ответа
pm.test("Проверить статус ответа", function () {
    pm.response.to.have.status(200); // Измените код ответа, если необходимо
});

// Проверка тела ответа
        pm.test("Проверить тело ответа", function () {
    var jsonData = pm.response.json();

    // Пример проверки для конкретных полей
    pm.expect(jsonData).to.have.property('key1', 'expectedValue1'); // Замените на реальные ключи и значения
    pm.expect(jsonData).to.have.property('key2', 'expectedValue2'); // Замените на реальные ключи и значения

    // Дополнительные проверки, если необходимо
    // pm.expect(jsonData.key3).to.eql('expectedValue3');
});


        pm.test("Проверка кода ответа", function () {
    pm.response.to.have.status(201); // Обычно POST возвращает 201
});

        pm.test("Проверка тела ответа", function () {
    var jsonData = pm.response.json();

    pm.expect(jsonData).to.have.property('name', 'New Item');
    pm.expect(jsonData).to.have.property('status', 'created');
});