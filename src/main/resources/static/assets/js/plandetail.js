const urlParams = new URLSearchParams(window.location.search);
const scheduleId = urlParams.get("scheduleId");
console.log(scheduleId);

const sceduleTable = document.querySelector("#schedule-list");

fetch(`/plan/detail/${scheduleId}`)
    .then((response) => response.json())
    .then((data) => {
        // 1. plan title
        document.querySelector("#plan-title").innerText = data.plan_title;
        // 2. start-date, end-date
        document.querySelector("#start-date").innerText = data.start_date;
        document.querySelector("#end-date").innerText = data.end_date;

        let count = 1;
        // 3. plan 순서대로 table에 넣기
        // TODO: attraction title에 detail 링크 넣기
        data.attractions.forEach((attraction) => {
            const row = document.createElement("tr");
            row.innerHTML = `
            <td>${count++}</td>
            <td>${attraction.title}</td>
            `;
            sceduleTable.appendChild(row);
        });
    })
    .catch((error) => console.error(error));
