const planTable = document.querySelector("#myPlanList");

fetch("/plan/getmyplan")
    .then((response) => response.json())
    .then((planlist) => {
        if (planlist && Array.isArray(planlist)) {
            // check if planlist is not undefined and is an array
            let planNo = 1;
            planlist.forEach((plan) => {
                console.log(plan);
                const row = document.createElement("tr");
                row.innerHTML = `
          <td>${planNo++}</td>
          <td><a href="../myplandetail.html?scheduleId=${plan.schedule_id}">${
                    plan.plan_title
                }</a></td>
          <td>${plan.start_date}</td>
          <td>${plan.end_date}</td>
        `;
                planTable.appendChild(row);
            });
        } else {
            console.error("Invalid response from server:", planlist);
        }
    })
    .catch((error) => console.error(error));
