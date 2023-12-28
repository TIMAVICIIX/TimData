function editInfo(editBtn) {

    const editRow = editBtn.parentNode.parentNode;
    const editCells = editRow.getElementsByTagName("td");

    for (let i = 2; i < editCells.length - 4; i++) {
        const cell = editCells[i];
        const originInfo = cell.innerText;

        if (i !== 3) {

            const editInput = document.createElement("input");

            if (i !== 6) {
                editInput.type = 'text';
            } else {
                editInput.type = 'number';
            }

            if (i === 4) {
                editInput.classList.add("body_input_large");
            } else if (i > 4) {
                editInput.classList.add("body_input_long");
            }else{
                editInput.classList.add("body_input_short");
            }

            editInput.value = originInfo;

            cell.innerHTML = "";
            cell.appendChild(editInput);

        }else{

            const editSelector = document.createElement("select");
            editSelector.classList.add("body_selector");
            editSelector.setAttribute("name","selector_sex");

            const maleOption = new Option("男","男");
            const femaleOption = new Option("女","女");

            if(originInfo === "男"){
                maleOption.setAttribute("selected","selected");
            }else {
                femaleOption.setAttribute("selected","selected");
            }

            editSelector.appendChild(maleOption);
            editSelector.appendChild(femaleOption);

            cell.innerHTML = "";
            cell.appendChild(editSelector);
        }

    }

    editBtn.innerHTML = "保存信息";
    editBtn.onclick = function (){
        saveInfo();
    }

}

function saveInfo(){

}