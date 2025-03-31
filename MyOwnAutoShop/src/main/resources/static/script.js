document.addEventListener('DOMContentLoaded', function () {
    let carTypeSelect = document.querySelector('select[name="type"]');
    let suvFields = document.getElementById('suvFields');
    let sedanFields = document.getElementById('sedanFields');

    carTypeSelect.addEventListener('change', function () {
        let selectedType = this.value;
        suvFields.style.display = selectedType === 'SUV' ? 'block' : 'none';
        sedanFields.style.display = selectedType === 'Sedan' ? 'block' : 'none';
    });

    document.getElementById('addCarForm').addEventListener('submit', function (event) {
        let carType = carTypeSelect.value;

        if (!carType) {
            alert("Please select a car type (SUV or Sedan).");
            event.preventDefault();
            return;
        }

        this.submit();
    });
});
