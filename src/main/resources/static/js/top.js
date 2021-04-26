'use strict';

const images = document.querySelectorAll('.image__place');

images.forEach((e, i) => {
    e.textContent = i + 1;
})