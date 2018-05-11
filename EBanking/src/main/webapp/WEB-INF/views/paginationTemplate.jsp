<nav aria-label="Page navigation">
  <ul class="pagination" ng-if="1 < pages.length || !autoHide">
      <li class="page-item" ng-if="boundaryLinks" ng-class="{ disabled : pagination.current == 1 }">
        <a ng-click="setCurrent(1)" class="page-link" href="" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">First</span>
        </a>
      </li>
      <li class="page-item" ng-if="directionLinks" ng-class="{ disabled : pagination.current == 1 }">
        <a ng-click="setCurrent(pagination.current - 1)" class="page-link" href="" aria-label="Previous">
          <span aria-hidden="true">&lsaquo;</span>
          <span class="sr-only">Previous</span>
        </a>
      </li>
      <li class="page-item" ng-repeat="pageNumber in pages track by tracker(pageNumber, $index)" ng-class="{ active : pagination.current == pageNumber, disabled : pageNumber == '...' }"><a class="page-link" href="" ng-click="setCurrent(pageNumber)">{{ pageNumber }}</a></li>
      <li class="page-item" ng-if="directionLinks" ng-class="{ disabled : pagination.current == pagination.last }">
        <a ng-click="setCurrent(pagination.current + 1)" class="page-link" href="" aria-label="Next">
          <span aria-hidden="true">&rsaquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>
      <li class="page-item" ng-if="boundaryLinks"  ng-class="{ disabled : pagination.current == pagination.last }">
        <a class="page-link" href="" aria-label="Next" ng-click="setCurrent(pagination.last)">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Last</span>
        </a>
      </li>
    </ul>
</nav>